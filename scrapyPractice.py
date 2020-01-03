import requests  

data = {
    'name' : 'germey',
    'age' : 22
}
request = requests.get('http://httpbin.org/get',params = data)
print(request.text)
