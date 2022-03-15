import request from '@/utils/request'

// 查询库存列表
export function listSurplus(query) {
  return request({
    url: '/goods/surplus/list',
    method: 'get',
    params: query
  })
}

// 查询库存详细
export function getSurplus(surplusId) {
  return request({
    url: '/goods/surplus/' + surplusId,
    method: 'get'
  })
}

// 新增库存
export function addSurplus(data) {
  return request({
    url: '/goods/surplus',
    method: 'post',
    data: data
  })
}

// 修改库存
export function updateSurplus(data) {
  return request({
    url: '/goods/surplus',
    method: 'put',
    data: data
  })
}

// 删除库存
export function delSurplus(surplusId) {
  return request({
    url: '/goods/surplus/' + surplusId,
    method: 'delete'
  })
}
