from flask import Blueprint

#
app_orders = Blueprint('app_orders',__name__)

@app_orders.route('/get_orders')
def get_orders():
    return 'get orders page'
