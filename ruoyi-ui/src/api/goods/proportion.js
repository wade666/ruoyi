import request from '@/utils/request'

// 查询商品规格换算列表
export function listProportion(query) {
  return request({
    url: '/goods/proportion/list',
    method: 'get',
    params: query
  })
}

// 查询商品规格换算详细
export function getProportion(conversionId) {
  return request({
    url: '/goods/proportion/' + conversionId,
    method: 'get'
  })
}

// 新增商品规格换算
export function addProportion(data) {
  return request({
    url: '/goods/proportion',
    method: 'post',
    data: data
  })
}

// 修改商品规格换算
export function updateProportion(data) {
  return request({
    url: '/goods/proportion',
    method: 'put',
    data: data
  })
}

// 删除商品规格换算
export function delProportion(conversionId) {
  return request({
    url: '/goods/proportion/' + conversionId,
    method: 'delete'
  })
}
