import request from '@/utils/request'

// 查询采购申请列表
export function listPurchase(query) {
  return request({
    url: '/goods/purchase/list',
    method: 'get',
    params: query
  })
}

// 查询采购申请详细
export function getPurchase(id) {
  return request({
    url: '/goods/purchase/' + id,
    method: 'get'
  })
}

// 新增采购申请
export function addPurchase(data) {
  return request({
    url: '/goods/purchase',
    method: 'post',
    data: data
  })
}

// 修改采购申请
export function updatePurchase(data) {
  return request({
    url: '/goods/purchase',
    method: 'put',
    data: data
  })
}

// 删除采购申请
export function delPurchase(id) {
  return request({
    url: '/goods/purchase/' + id,
    method: 'delete'
  })
}
