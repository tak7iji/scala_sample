package test

import fpinscala.datastructures._

import org.openjdk.jmh.annotations._

class Bench {
  @Benchmark
  def sum1(): Unit = List.sum(List(1,2,3,4,5))

  @Benchmark
  def sum2(): Unit = List.sum2(List(1,2,3,4,5))

  @Benchmark
  def sum3(): Unit = List.sum3(List(1,2,3,4,5))
}
