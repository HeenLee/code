from app import app

@app.route('/')
def admin_home():
    return 'admin_home'

@app.route('/new')
def new():
    return 'new'

@app.route('/edit')
def edit():
    return 'edit'
