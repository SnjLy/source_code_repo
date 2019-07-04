package search.listenner;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.techwolf.oceanus.search.listenner
 *
 * @author: SNJly
 * @date: 2019-06-27
 */
@Service
@Slf4j
public class EventHandlerManager {

    private  ConcurrentHashMap<String, AbstractEventHandler> byHandlerName = new ConcurrentHashMap<>();

    @Autowired
    private ListableBeanFactory beanFactory;

    public AbstractEventHandler getHandlerByName(String handlerName) {
        if (StringUtils.isBlank(handlerName)) {
            return null;
        }
        return byHandlerName.get(handlerName);
    }


    public void registerHandlerByName(String handlerName, AbstractEventHandler eventHandler) {
        if (StringUtils.isBlank(handlerName)) {
            throw new IllegalArgumentException("handlerName is blank!");
        }
        if (null == eventHandler) {
            throw new IllegalArgumentException("handler is null, handlerName [" + handlerName + "]!");
        }
        AbstractEventHandler handler = byHandlerName.putIfAbsent(handlerName, eventHandler);
        if (null != handler) {
            throw new IllegalArgumentException("repetitive message handler, handlerName [" + handlerName + "]!");
        }
        log.info("handler [{}] registry complete.", handlerName);
    }


    @PostConstruct
    public void registerHandler(){
        registerHandlerByName(KafkaEventHandler.KAFKA_HANDLER,beanFactory.getBean(KafkaEventHandler.class));
        registerHandlerByName(CanalEventHandler.CANAL_HANDLER,beanFactory.getBean(CanalEventHandler.class));
    }



//    @KafkaListener(id="${spring.kafka.consumer.groupId}",topics = {"${spring.kafka.consumer.actionTopic}"})
//    public void input(ConsumerRecord consumerRecord) {
//        JSONObject recordValue= JSONObject.parseObject(String.valueOf(consumerRecord.value()));
//        String action=recordValue.getString("action");
//
//        this.convert2EventEntity(consumerRecord);
//        getHandlerByName(KafkaEventHandler.KAFKA_HANDLER).accept(consumerRecord);
//
//    }

}
