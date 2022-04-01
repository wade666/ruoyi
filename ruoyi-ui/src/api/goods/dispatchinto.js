import request from '@/utils/request'

// 查询调拨出入库单列表
export function listDispatchinto(query) {
  return request({
    url: '/goods/dispatchinto/list',
    method: 'get',
    params: query
  })
}

// 查询调拨出入库单详细
export function getDispatchinto(id) {
  return request({
    url: '/goods/dispatchinto/' + id,
    method: 'get'
  })
}

// 新增调拨出入库单
export function addDispatchinto(data) {
  return request({
    url: '/goods/dispatchinto',
    method: 'post',
    data: data
  })
}

// 修改调拨出入库单
export function updateDispatchinto(data) {
  return request({
    url: '/goods/dispatchinto',
    method: 'put',
    data: data
  })
}

// 删除调拨出入库单
export function delDispatchinto(id) {
  return request({
    url: '/goods/dispatchinto/' + id,
    method: 'delete'
  })
}
