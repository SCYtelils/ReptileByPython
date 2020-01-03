import requests  

request = requests.get('http://httpbin.org/get')
print(type(request.text))
print(request.json())
print(type(request.json()))
