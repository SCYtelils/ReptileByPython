import requests  

request = requests.get('http://httpbin.org/get')
print(request.text)
