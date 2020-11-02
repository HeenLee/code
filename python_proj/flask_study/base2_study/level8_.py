from flask import Flask
from base2_study.level9_orders import app_orders

#
app = Flask(__name__)

# app.register_blueprint(app_orders)
app.register_blueprint(app_orders,url_prefix='/orders')

if __name__ == '__main__':
    print(app.url_map)
    app.run()
