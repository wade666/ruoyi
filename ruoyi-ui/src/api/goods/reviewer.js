import request from '@/utils/request'

// 查询采购审核人配置列表
export function listReviewer(query) {
  return request({
    url: '/goods/reviewer/list',
    method: 'get',
    params: query
  })
}

// 查询采购审核人配置详细
export function getReviewer(id) {
  return request({
    url: '/goods/reviewer/' + id,
    method: 'get'
  })
}

// 新增采购审核人配置
export function addReviewer(data) {
  return request({
    url: '/goods/reviewer',
    method: 'post',
    data: data
  })
}

// 修改采购审核人配置
export function updateReviewer(data) {
  return request({
    url: '/goods/reviewer',
    method: 'put',
    data: data
  })
}

// 删除采购审核人配置
export function delReviewer(id) {
  return request({
    url: '/goods/reviewer/' + id,
    method: 'delete'
  })
}
