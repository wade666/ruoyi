import request from '@/utils/request'

// 查询出入库明细列表
export function listSurplusdetails(query) {
  return request({
    url: '/goods/surplusdetails/list',
    method: 'get',
    params: query
  })
}

// 查询出入库明细详细
export function getSurplusdetails(id) {
  return request({
    url: '/goods/surplusdetails/' + id,
    method: 'get'
  })
}

// 新增出入库明细
export function addSurplusdetails(data) {
  return request({
    url: '/goods/surplusdetails',
    method: 'post',
    data: data
  })
}

// 修改出入库明细
export function updateSurplusdetails(data) {
  return request({
    url: '/goods/surplusdetails',
    method: 'put',
    data: data
  })
}

// 删除出入库明细
export function delSurplusdetails(id) {
  return request({
    url: '/goods/surplusdetails/' + id,
    method: 'delete'
  })
}
