package tree.common;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jinli Dec 24, 2015
 */
public class NodeEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Integer NODE_GROUP_MEMBER = 1;
    public static final Integer NODE_GROUP_MEMBER_SNAPSHOTED = 2;
    public static final Integer[] NODE_GROUPS = { NODE_GROUP_MEMBER, NODE_GROUP_MEMBER_SNAPSHOTED };

    public static final Integer TYPE_ADD = 1;
    public static final Integer TYPE_DELETE = 2;
    public static final Integer TYPE_UPDATE = 3;
    public static final Integer[] TYPES = { TYPE_ADD, TYPE_DELETE, TYPE_UPDATE };

    private Long id;                        // ID主键
    private Integer type;                   // 操作类型:TYPES
    private Integer nodeGroup;              // 节点类型: 1:member
    private Long nodeId;                    // 节点ID
    private Long parentId;                  // 父节点ID
    private Long rootId;                    // 根节点ID
    private Map<String, Object> body;       // 内容

    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;

    public void addBodyAttribute(String key, Object value) {
        if (body == null) {
            body = new HashMap<>();
        }
        body.put(key, value);
    }
    @SuppressWarnings("unchecked")
    public <T> T getBodyAttribute(String key) {
        return body != null ? (T) body.get(key) : null;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNodeGroup() {
        return nodeGroup;
    }

    public void setNodeGroup(Integer nodeGroup) {
        this.nodeGroup = nodeGroup;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * <pre>
     * Node <--> NodeEvent 转换器
     * </pre>
     *
     * @author jinli Dec 24, 2015
     */
    public static interface NodeEventConvertor<T extends Node<T>> {

        /**
         * event --> node
         * 
         * @param event
         * @return
         */
        T toNode(NodeEvent event);

        /**
         * node --> event
         * 
         * @param node
         * @return
         */
        NodeEvent toEvent(T node);

    }

}
