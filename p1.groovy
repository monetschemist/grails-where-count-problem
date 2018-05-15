def c = gtest01.TestA.where {
	value > 0.5d
}
c.list().each { t ->
	println "t.sample ${t.sample} t.value ${t.value}"
}
println c.count()
