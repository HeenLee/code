"""
��ȡλ�ü�����ָ��λ��
# ��ȡ�ļ���λ��
file_name = "D:/hello.txt"with open(file_name, "rb") as file_obj:
    # print(file_obj.read(100))
    # print(file_obj.read(20))
    # seek()�����޸ĵ�ǰ��ȡ��λ��
    file_obj.seek(55)
    file_obj.seek(70,1)  #�ӵ�ǰ�Ķ������ǰ����ָ�룬�ͼ���
    #file_obj.seek(1,2)  #�����λ�ö�    


    # seek()��Ҫ��������
    # ��һ����Ҫ�л�����λ��
     # �ڶ��� ����λ�÷�ʽ
      # ��ѡֵ
      # 0 ��ͷ���㣬Ĭ��ֵ
      # 1 �ӵ�ǰλ�ü���
      # 2 �����λ�ÿ�ʼ����
      file_obj.read()
       # tell()���������鿴��ǰ��ȡ��λ��
       print("��ǰ��ȡ����-->", file_obj.tell())


#�ļ����������� ɾ�������������ƶ�
import os
#listdir() ��ȡָ��Ŀ¼�ṹ����Ҫһ��·����Ϊ�����������б�
r = os.listdir()
#getcwd()��ȡ��ǰ����Ŀ¼
r = os.getcwd()
#chdir()�л���ǰĿ¼
os.chdir("..")
r = os.getcwd()
#mkdir()����Ŀ¼
#rmdir()ɾ��Ŀ¼
#remove()ɾ���ļ�
#rename()������  Ҳ�����ƶ�һ���ļ�
print(r)
"""