import request from '@/utils/request'

// 查询供货商列表
export function listSupplier(query) {
  return request({
    url: '/goods/supplier/list',
    method: 'get',
    params: query
  })
}

// 查询供货商详细
export function getSupplier(id) {
  return request({
    url: '/goods/supplier/' + id,
    method: 'get'
  })
}

// 新增供货商
export function addSupplier(data) {
  return request({
    url: '/goods/supplier',
    method: 'post',
    data: data
  })
}

// 修改供货商
export function updateSupplier(data) {
  return request({
    url: '/goods/supplier',
    method: 'put',
    data: data
  })
}

// 删除供货商
export function delSupplier(id) {
  return request({
    url: '/goods/supplier/' + id,
    method: 'delete'
  })
}
