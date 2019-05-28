namespace java com.spring.demo.service.api

//Gateway部分已经完成


//engine部分
//1. 查询问题配置及答案
//2. 查询问题会话及相关问题
//3. 重排序
service ChatBotProcessService{
    void process(1:string req, 2:i32 type);
}


//data部分
/**
* 1. 获取会话数据
* 2. 数据聚合
* 3. 请求reRank
* 4. 数据封装
*
* 5. 会话记录保存
* 6. 反馈信息保存
**/


//search部分
/**
* 1. 索引数据
*      全量数据表:聊天客服后台配置表
*      全量索引到es
* 2. 增量索引数据
* 3. 处理query查询
*       查询问题答案
*       查询相关问题
**/

struct ChatBotKehu{
1:required string qid;
2:required string query;
3:required string question;
4:required string answer;
5:required string ktag;
6:required i16    valid;
7:optional string startTime;
8:optional string endTime;
9:optional string updateTime;
}

//索引请求
struct ChatBotIndexRequest{

}

//索引结果
struct ChatBotIndexResponse{

}

//查询请求
struct ChatBotQueryRequest{

}
//查询结果
struct ChatBotQueryResponse{

}

service ChatBotIndexService{
    ChatBotIndexResponse index(1:ChatBotIndexRequest req);
}

service ChatBotQueryService{
    ChatBotQueryRequest query(1:ChatBotQueryRequest req);
}