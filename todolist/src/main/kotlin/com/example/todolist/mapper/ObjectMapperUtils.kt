package com.example.todolist.mapper

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
object ObjectMapperUtils {

    private var modelMapper = ModelMapper()

    /**
     *
     * Note: outClass object must have default constructor with no arguments
     *
     * @param <D>      type of result object.
     * @param <T>      type of source object to map from.
     * @param entity   entity that needs to be mapped.
     * @param outClass class of result object.
     * @return new object of `outClass` type.
     */
    fun <D, T> map(entity: T, outClass: Class<D>?): D {
        return modelMapper.map(entity, outClass)
    }

    /**
     *
     * Note: outClass object must have default constructor with no arguments
     *
     * @param entityList list of entities that needs to be mapped
     * @param outCLass   class of result list element
     * @param <D>        type of objects in result list
     * @param <T>        type of entity in `entityList`
     * @return list of mapped object with `<D></D>` type.
     */
    fun <D, T> mapAll(entityList: Collection<T>, outCLass: Class<D>?): List<D> {
        return entityList.stream()
                .map { entity: T -> map(entity, outCLass) }
                .collect(Collectors.toList())
    }

    /**
     * Maps `source` to `destination`.
     *
     * @param source      object to map from
     * @param destination object to map to
     */
    fun <S, D> map(source: S, destination: D): D {
        modelMapper.map(source, destination)
        return destination
    }

    /**
     * Model mapper property setting are specified in the following block.
     * Default property matching strategy is set to Strict see [MatchingStrategies]
     * Custom mappings are added using [ModelMapper.addMappings]
     */
    init {
        modelMapper = ModelMapper()
        modelMapper.configuration.matchingStrategy = MatchingStrategies.STRICT
        modelMapper.configuration.isSkipNullEnabled = true
    }
}