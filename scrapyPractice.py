import urllib.request
import urllib.parse

#bytes方法：将参数转化为字节流编码格式的内容，即bytes
data = bytes(urllib.parse.urlencode({'word':'hello'}),encoding='utf8')  
response = urllib.request.urlopen('http://httpbin.org/post',data=data)
print(response.read())
