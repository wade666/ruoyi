import request from '@/utils/request'

// 查询配送方式列表
export function listMethod(query) {
  return request({
    url: '/goods/method/list',
    method: 'get',
    params: query
  })
}

// 查询配送方式详细
export function getMethod(id) {
  return request({
    url: '/goods/method/' + id,
    method: 'get'
  })
}

// 新增配送方式
export function addMethod(data) {
  return request({
    url: '/goods/method',
    method: 'post',
    data: data
  })
}

// 修改配送方式
export function updateMethod(data) {
  return request({
    url: '/goods/method',
    method: 'put',
    data: data
  })
}

// 删除配送方式
export function delMethod(id) {
  return request({
    url: '/goods/method/' + id,
    method: 'delete'
  })
}
