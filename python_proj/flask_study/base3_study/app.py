from flask import  Flask
from admin import *

app = Flask(__name__)

@app.route('/')
def index():
    return 'index'

@app.route('/list')
def list():
    return 'list'

@app.route('/detail')
def detail():
    return 'detail'

if __name__ == '__main__':
    app.run()
