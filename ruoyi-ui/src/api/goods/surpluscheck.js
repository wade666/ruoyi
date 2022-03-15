import request from '@/utils/request'

// 查询库存盘点列表
export function listSurpluscheck(query) {
  return request({
    url: '/goods/surpluscheck/list',
    method: 'get',
    params: query
  })
}

// 查询库存盘点详细
export function getSurpluscheck(id) {
  return request({
    url: '/goods/surpluscheck/' + id,
    method: 'get'
  })
}

// 新增库存盘点
export function addSurpluscheck(data) {
  return request({
    url: '/goods/surpluscheck',
    method: 'post',
    data: data
  })
}

// 修改库存盘点
export function updateSurpluscheck(data) {
  return request({
    url: '/goods/surpluscheck',
    method: 'put',
    data: data
  })
}

// 删除库存盘点
export function delSurpluscheck(id) {
  return request({
    url: '/goods/surpluscheck/' + id,
    method: 'delete'
  })
}
