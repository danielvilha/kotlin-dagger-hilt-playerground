package com.danielvilha.hilt_playerground.datasource.cache.mappers

import com.danielvilha.hilt_playerground.business.domain.models.Blog
import com.danielvilha.hilt_playerground.business.domain.util.EntityMapper
import com.danielvilha.hilt_playerground.datasource.cache.model.BlogCacheEntity
import javax.inject.Inject

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
class CacheMapper @Inject constructor(): EntityMapper<BlogCacheEntity, Blog> {
    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }

    fun mapFromEntityList(entities: List<BlogCacheEntity>): List<Blog>{
        return entities.map { mapFromEntity(it) }
    }
}