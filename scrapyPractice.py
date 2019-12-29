from urllib.request import *
from urllib.error import *

url = 'http://www.baidu.com'
proxy_handler = ProxyHandler({
    'http':'http://110.6.143.140:6666',
    'http':'https://110.6.143.140:6666'
})

opener = build_opener(proxy_handler)

try:
    response = opener.open(url)
    print(response.read().decode('utf-8'))
except URLError as e:
    print(e.reason)
