from flask import Flask,render_template
app = Flask(__name__)

@app.route('/if')
def index():
    # user = 'sino'
    return render_template('if.html')

@app.route('/for')
def index_for():
    fruit = ['apple','orange','pear','grape']
    return render_template('loop.html',fruit=fruit)


if __name__ == '__main__':
    app.run(debug=True)
