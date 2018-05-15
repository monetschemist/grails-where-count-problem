def c = gtest01.TestA.where {
	projections {
		groupProperty 'grouping'
		count()
	}
}
c.list().each { t ->
	println "t $t"
}
println c.count()
