"""
#��ȡ���ļ�file_name = "d:/abc.txt"
try:
    with open(file_name,encoding="utf-8") as file_obj:
        file_content = ""
        #����һ����������ָ��ÿ�ζ�ȡ�Ĵ�С
        chunk = 100
         #����ѭ����ȡ�ļ�������
         while True:
         #��ȡchunk��С������
            content = file_obj.read(chunk)
            #����Ƿ��ȡ��������
             if not content:
                break
                 #�������
            print(content, end="")
            file_content += content
except FileNotFoundError:
    print('{file_name} �ļ�������')
print(file_content)


# һ��һ�ж�ȡ
file_name = "d:/hello.txt"
with open(file_name, encoding="utf-8") as file_obj:
    #content = file_obj.read()
    #readline()ÿ��һ�ж�ȡ
     #readlines()�÷�������һ��һ�ж�ȡ���ݣ�һ���Խ���ȡ�������ݷ�װ���б��з���
     #print(file_obj.readline())
     print(file_obj.readlines()[0])    #
     �����file_objҲ��һ��һ�ж�ȡ
     for t in file_obj:
        print(t)



"""