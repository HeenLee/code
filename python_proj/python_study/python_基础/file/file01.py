"""
1.
#with ... as ����ļ��Զ��ر�
file_name = "d:/abc.txt"
with open(file_name) as file_obj:
    #��with����п���ֱ��ʹ��file_obj���ļ�����
    print(file_obj.read())
eg.1
try:
    with open(file_name) as file_obj:
        print(file_obj.read())
except FileNotFoundError:
    print(f"{file_name} �ļ�������")

2.
�ļ���ȡread() read(size) readline() readlines()
����open()���ļ������Է�Ϊ���ı��ļ���ʹ��utf-8�ȱ����д���ı��ļ�������һ���Ƕ������ļ���ͼƬ��mp3��ppt��
Open()���ļ�ʱ��Ĭ�����ı��ļ�����ʽ�򿪣�����open()Ĭ�ϱ���Ϊnull������������
�����ı��ļ�ʱ������ָ���ļ��ı���
file_name = "d:/abc.txt"
try:
    with open(file_name,encoding="utf-8") as file_obj:
        print(file_obj.read())
except FileNotFoundError:
    print("{file_name} �ļ�������")

Read(size)���ò�������ָ��Ҫ��ȡ���ַ���������
Ĭ��ֵΪ-1�������ȡ�ļ��е������ַ�
����Ϊsizeָ��һ��ֵ������read()���ȡָ���������ַ���
	ÿһ�ζ�ȡ���Ǵ��ϴζ�ȡ��λ�ÿ�ʼ��ȡ��
	����ַ�������С��size������ȡʣ�����е�
	�����ȡ�����ļ������᷵�ء����մ�

file_name = "d:/abc.txt"
try:
    with open(file_name,encoding="utf-8") as file_obj:
        content = file_obj.read(1000)
        print(content)
        print(len(content))
except FileNotFoundError:
    print('{file_name} �ļ�������')


"""
