import scrapy

class ChemItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    catalog=scrapy.Field()
    amount=scrapy.Field()
    price=scrapy.Field()
    qty=scrapy.Field()