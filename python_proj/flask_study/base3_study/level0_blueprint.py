from flask import Flask, Blueprint

# 创建蓝图对象
#Blueprint必须指定两个参数，admin表示蓝图的名称，__name__表示蓝图所在模块
admin = Blueprint('admin',__name__)

#注册蓝图路由
# @admin.route('/')
# def admin_index():
#     return 'admin_index'
#
# #在程序实例中注册该蓝图
# app.register_blueprint(admin,url_prifix='/admin')

