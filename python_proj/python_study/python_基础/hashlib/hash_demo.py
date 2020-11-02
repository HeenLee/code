# _*_ coding=utf8 _*_

print(chr(65))   #Unicode码  转str

print(ord('A'))  # str转 Unicode码

# bin()  #转二进制
# hex()  #转十六进制
# oct()  #转八进制

import hashlib
#md5加密   #md5  sha1  sha256单向加密    base64是可解码的
msg = 'abc'     #加密算法对字符先编码
md5 = hashlib.md5(msg.encode('utf8'))
print(md5.hexdigest())  #16进制输出


sha = hashlib.sha1(msg.encode('utf8'))
print(sha.hexdigest())
