import flask,os,sys,time
from flask import request,send_from_directory

interface_path = os.path.dirname(__file__)
sys.path.insert(0,interface_path)

server = flask.Flask(__name__)

#get方法：指定目录下载文件
@server.route('/download',methods=['get'])
def download():
    fpath = request.values.get('path','')
    fname = request.values.get('filename','')
    if fname.strip() and fpath.strip():
        print(fpath,fname)
        if os.path.isfile(os.path.join(fpath,fname)) and os.path.isdir(fpath):
            return send_from_directory(fpath,fname)
        else:
            return '{"msg":"参数不正确"}'
    else:
        return  '{"msg":"请输入参数"}'

#get方法：查询当前路径下的所有文件
@server.route('/getfiles',methods=['get'])
def getfiles():
    fpath = request.values.get('fpath','')
    print(fpath)
    if os.path.isdir(fpath):
        fileList = os.listdir(fpath)
        files = []
        for file in fileList:
            if os.path.isfile(os.path.join(fpath,file)):
                files.append(file)
        return '{"files":"%s"}' % files

#post方法：上传文件
@server.route('/upload',methods=['post'])
def upload():
    fname = request.files.get('file')
    if fname:
        t = time.strftime('%Y%m%d%H%M%S')
        new_fname = r'upload/' + t + fname.filename
        fname.save(new_fname)
        return '{"code":"OK"}'
    else:
        return '{"msg":"请上传文件"}'
server.run(port=8012,debug=True)


