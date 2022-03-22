import request from '@/utils/request'

// 查询采购申请列表
export function listPurchase(query) {
  return request({
    url: '/goods/purchaseCheck/list',
    method: 'get',
    params: query
  })
}

// 查询采购申请详细
export function getPurchase(id) {
  return request({
    url: '/goods/purchaseCheck/' + id,
    method: 'get'
  })
}

// 修改采购申请
export function updatePurchase(data) {
  return request({
    url: '/goods/purchaseCheck',
    method: 'put',
    data: data
  })
}
