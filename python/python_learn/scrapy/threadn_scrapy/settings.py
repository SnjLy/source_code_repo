FEED_EXPORTERS = {
    'csv': 'tutorial.spiders.csv_item_exporter.MyProjectCsvItemExporter',
} #tutorial为工程名

FIELDS_TO_EXPORT = [
    'catalog',
    'amount',
    'price',
    'qty'
]

LINETERMINATOR='\n'


ITEM_PIPELINES = {
   'tutorial.pipelines.MySQLStorePipeline': 300,
}

# start MySQL database configure setting
MYSQL_HOST = 'localhost'
MYSQL_DBNAME = 'test'
MYSQL_USER = 'root'
MYSQL_PASSWD = 'password'
# end of MySQL database configure setting