#encoding=utf8
import urllib.request  #py3.x 需要用urllib.request
from bs4 import *

res = urllib.request.urlopen("http://www.douban.com/tag/%E5%B0%8F%E8%AF%B4/?focus=book")
soup = BeautifulSoup.BeautifulSoup(res)
book_div = soup.find(attrs={"id":"book"})
book_a = book_div.findAll(attrs={"class":"title"})
for book in book_a:
    print(book.string)