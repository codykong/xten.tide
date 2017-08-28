package com.xten.tide.runtime.runtime.component

import com.xten.tide.api.functions.BaseFunction
import com.xten.tide.configuration.Configuration
import com.xten.tide.runtime.runtime.jobgraph.Task

import scala.collection.mutable

/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/5/23 
  */
class ComponentContext[T <: BaseFunction](val taskId:String,val function: T,val componentConfig : Configuration,val receivers : List[String]) {

}

object ComponentContext {

  def apply[T <: BaseFunction](taskId:String,function: T,taskConfig : Configuration) :ComponentContext[T] = {

    new ComponentContext[T](taskId,function,taskConfig,List.empty)
  }

  def apply[T <: BaseFunction](function: T,componentNode:Task) :ComponentContext[T] = {


    new ComponentContext[T](componentNode.taskId,function,componentNode.executionConfig,componentNode.receivers)
  }
}
