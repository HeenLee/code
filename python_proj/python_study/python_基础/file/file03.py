"""
�ļ�д��
# �ļ�д�� write   write�����ػ᷵��д����ַ��ĸ���
file_name = ��d:/hello.txt��
#ʹ��open���ļ�ʱ����ָ�����ļ���ģʽ������д��׷�ӣ� �����ָ���������ͣ�Ĭ���Ƕ�ȡ��
��ȡ�ǲ��ܹ�д���
#ʹ��wд���ļ�ʱ������ļ������ڻᴴ���ļ�������ļ�������Ḳ��֮ǰ������#a׷��ģʽ
#+Ϊ���������ӹ���
# r+ �ȿɶ��ֿ�д���ļ������ڻᱨ��
# w+
# a+
with open(file_name, encoding=��utf-8��,mode=��a��) as file_obj:
    file_obj.write(��123\n��)    \nд�뻻�з�
    file_obj.write(��abc��)
    lists = [��1��,��2��]
    file_obj.writelines(lists)  д����



�������ļ���д
# �������ļ�  ͼƬ mp3
# ��ȡģʽ
# t ��ȡ�ı��ļ�(Ĭ��ֵ)
# b ��ȡ�������ļ�
file_name = "C:\\Users\\lihe\\Desktop\\Penguins.jpg"with open(file_name, "rb") as file_obj:
    # ��ȡ�ı��ļ�ʱ��size�����ַ�Ϊ��λ��
    # ��ȡ�������ļ�ʱ��size�����ֽ�Ϊ��λ��
    #print(file_obj.read(100)) #һ�ζ�ȡ100�ֽ�
    # ����ȡ��������д����
    # ����һ���µ��ļ�
    new_name = "d:/a.jpg"
    with open(new_name, "wb") as new_obj:
        # ����ÿ�ζ�ȡ�Ĵ�С
        chunk = 1024 * 10
        while True:
            # �����еĶ����ж�ȡ����
            content = file_obj.read(chunk)
            # ���ݶ�ȡ��ϣ���ֹѭ��
            if not content:
                break
            # ����ȡ��������д�뵽�¶�����
            new_obj.write(content)


"""