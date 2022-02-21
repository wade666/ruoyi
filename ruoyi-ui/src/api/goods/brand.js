import request from '@/utils/request'

// 查询商品品牌列表
export function listBrand(query) {
  return request({
    url: '/goods/brand/list',
    method: 'get',
    params: query
  })
}
// 查询品牌列表（排除节点）
export function listBrandExcludeChild(deptId) {
  return request({
    url: '/goods/brand/list/exclude/' + deptId,
    method: 'get'
  })
}
// 查询商品品牌详细
export function getBrand(brandId) {
  return request({
    url: '/goods/brand/' + brandId,
    method: 'get'
  })
}
// 查询品牌下拉树结构
export function treeselect() {
  return request({
    url: '/goods/brand/treeselect',
    method: 'get'
  })
}

// 新增商品品牌
export function addBrand(data) {
  return request({
    url: '/goods/brand',
    method: 'post',
    data: data
  })
}

// 修改商品品牌
export function updateBrand(data) {
  return request({
    url: '/goods/brand',
    method: 'put',
    data: data
  })
}

// 删除商品品牌
export function delBrand(brandId) {
  return request({
    url: '/goods/brand/' + brandId,
    method: 'delete'
  })
}
