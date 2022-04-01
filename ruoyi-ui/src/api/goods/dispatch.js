import request from '@/utils/request'

// 查询调拨单列表
export function listDispatch(query) {
  return request({
    url: '/goods/dispatch/list',
    method: 'get',
    params: query
  })
}

// 查询调拨单详细
export function getDispatch(id) {
  return request({
    url: '/goods/dispatch/' + id,
    method: 'get'
  })
}

// 新增调拨单
export function addDispatch(data) {
  return request({
    url: '/goods/dispatch',
    method: 'post',
    data: data
  })
}

// 修改调拨单
export function updateDispatch(data) {
  return request({
    url: '/goods/dispatch',
    method: 'put',
    data: data
  })
}

// 删除调拨单
export function delDispatch(id) {
  return request({
    url: '/goods/dispatch/' + id,
    method: 'delete'
  })
}
