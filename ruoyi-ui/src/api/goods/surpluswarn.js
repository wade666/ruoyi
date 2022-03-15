import request from '@/utils/request'

// 查询库存预警设置列表
export function listSurpluswarn(query) {
  return request({
    url: '/goods/surpluswarn/list',
    method: 'get',
    params: query
  })
}

// 查询库存预警设置详细
export function getSurpluswarn(id) {
  return request({
    url: '/goods/surpluswarn/' + id,
    method: 'get'
  })
}

// 新增库存预警设置
export function addSurpluswarn(data) {
  return request({
    url: '/goods/surpluswarn',
    method: 'post',
    data: data
  })
}

// 修改库存预警设置
export function updateSurpluswarn(data) {
  return request({
    url: '/goods/surpluswarn',
    method: 'put',
    data: data
  })
}

// 删除库存预警设置
export function delSurpluswarn(id) {
  return request({
    url: '/goods/surpluswarn/' + id,
    method: 'delete'
  })
}
