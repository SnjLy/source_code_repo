

namespace java com.techwolf.oceanus.api.search

include "Header.thrift"

struct JobIndexData{
    1:optional string id;
    2:optional string lables;
}

struct JobSearchIndexResult{
    1:optional string schema;
    2:optional string type;
    3:optional string optType;
    4:optional string result;
}

struct JobSearchIndexRequest{
    1:required Header.RequestHeader requestHeader;
    2:required string requestId;
    3:required string schema;
    4:required string type;
    5:required i16 optType;
    6:optional list<JobIndexData> datas;
}

struct JobSearchIndexResponse{
    1:required Header.ResponseHeader responseHeader;
    2:required string requestId;
    3:optional list<JobSearchIndexResult> results;
}

service JobSearchIndexService{

    JobSearchIndexResponse index(1:optional JobSearchIndexRequest indexRequest);
    JobSearchIndexResponse update(1:optional JobSearchIndexRequest indexRequest);
    JobSearchIndexResponse delete(1:optional JobSearchIndexRequest indexRequest);
}





struct JobSearchQueryRequest{
    1:required Header.RequestHeader requestHeader;
    2:required string requestId;

}
struct JobSearchQueryResponse{
    1:required Header.ResponseHeader responseHeader;
    2:required string requestId;

}

service JobSearchQueryService{
    JobSearchQueryResponse query(1:optional JobSearchQueryRequest searchRequest);
}
