package com.danielvilha.hilt_playerground.datasource.network.mappers

import com.danielvilha.hilt_playerground.business.domain.models.Blog
import com.danielvilha.hilt_playerground.business.domain.util.EntityMapper
import com.danielvilha.hilt_playerground.datasource.network.model.BlogNetworkEntity
import javax.inject.Inject

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
class NetworkMapper @Inject constructor(): EntityMapper<BlogNetworkEntity, Blog> {
    override fun mapFromEntity(entity: BlogNetworkEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogNetworkEntity {
        return BlogNetworkEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }

    fun mapFromEntityList(entities: List<BlogNetworkEntity>): List<Blog>{
        return entities.map { mapFromEntity(it) }
    }
}