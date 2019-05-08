namespace java rpc.thrift.demo1

enum StatusEnum {
    Ok=200,
    Fail=500,
    NoAuth=403,
    TimeOut=503,
    Limit=509
}


struct RequestHeader {
    1:optional string token;
    2:optional string ip;
    3:optional string version;
    4:optional string consumer;
    5:optional Platform platform;
}

enum Platform{
    APP,WEB
}

struct ResponseHeader {
    1:optional StatusEnum status=StatusType.Ok;
    2:optional string message;
}

struct Pageable{
     1:optional i32 pageNumber=1;
     2:optional i32 pageSize=10;
     3:optional i32 totalPage=0;
     4:optional i32 totalCount=0;
     5:optional i32 offset=0;
}

service DemoService {
    ResponseHeader query(1:string param, 2: Pageable page);
    void addDemo(1:RequestHeader request);
}
