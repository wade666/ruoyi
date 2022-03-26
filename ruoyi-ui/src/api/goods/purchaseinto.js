import request from '@/utils/request'

// 查询采购入库单列表
export function listPurchaseinto(query) {
  return request({
    url: '/goods/purchaseinto/list',
    method: 'get',
    params: query
  })
}

// 查询采购入库单详细
export function getPurchaseinto(id) {
  return request({
    url: '/goods/purchaseinto/' + id,
    method: 'get'
  })
}

// 新增采购入库单
export function addPurchaseinto(data) {
  return request({
    url: '/goods/purchaseinto',
    method: 'post',
    data: data
  })
}

// 修改采购入库单
export function updatePurchaseinto(data) {
  return request({
    url: '/goods/purchaseinto',
    method: 'put',
    data: data
  })
}

// 删除采购入库单
export function delPurchaseinto(id) {
  return request({
    url: '/goods/purchaseinto/' + id,
    method: 'delete'
  })
}
