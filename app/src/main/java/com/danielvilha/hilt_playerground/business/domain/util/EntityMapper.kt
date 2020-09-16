package com.danielvilha.hilt_playerground.business.domain.util

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
interface EntityMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel

    fun mapToEntity(domainModel: DomainModel): Entity
}