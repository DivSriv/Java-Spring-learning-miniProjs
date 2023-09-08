package com.spring.basics.springsteps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {
    @Autowired
    @Qualifier("quick")

    private SortAlgo sortAlgo;
//    private SortAlgo bubbleSortAlgo;

//    public void setSortAlgo(SortAlgo sortAlgo) {
//        this.sortAlgo = sortAlgo;
//    }
//    public BinarySearchImpl(SortAlgo sortAlgo){
//        super();
//        this.sortAlgo = sortAlgo;
//    }
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public int binarySearch(int[] numbers, int numberToSearchFor) {

        int[] sortedNumbers = sortAlgo.sort(numbers);
        System.out.println(sortAlgo);
        // Search the array
        return 3;
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("postConstruct");
    }
    @PreDestroy
    public void preDestroy(){
        logger.info("preDestroy");
    }
}
