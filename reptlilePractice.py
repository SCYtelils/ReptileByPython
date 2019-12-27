#encoding=utf8
import urllib.request  #py3.x 需要用urllib.request
from bs4 import *
from selenium import webdriver

browser = webdriver.Chrome()

res = urllib.request.urlopen("http://jwxt.qlu.edu.cn/jsxsd/jxzl/jxzl_query?Ves632DSdyV=NEW_XSD_WDZM")
soup = BeautifulSoup(res,'lxml')
# book_div = soup.find(attrs={"id":"book"})  #通过id=book获取div标签
# book_a = book_div.findAll(attrs={"class":"title"})  #通过class="title"获取所有的book a标签
# for book in book_a:
#     print(book.string)

html = """
<html><head><title>The Dormouse's story</title></head>
<body>
<p class="title" name="dromouse"><b>The Dormouse's story</b></p>
<p class="story">Once upon a time there were three little sisters; and their names were
<a href="http://example.com/elsie" class="sister" id="link1"><!-- Elsie --></a>,
<a href="http://example.com/lacie" class="sister" id="link2">Lacie</a> and
<a href="http://example.com/tillie" class="sister" id="link3">Tillie</a>;
and they lived at the bottom of a well.</p>
<p class="story">...</p>
"""
# soup = BeautifulSoup(html, 'lxml')
print(soup.table)
