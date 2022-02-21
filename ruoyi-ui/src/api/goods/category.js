import request from '@/utils/request'

// 查询商品分类列表
export function listCategory(query) {
  return request({
    url: '/goods/category/list',
    method: 'get',
    params: query
  })
}
// 查询分类列表（排除节点）
export function listCategoryExcludeChild(deptId) {
  return request({
    url: '/goods/category/list/exclude/' + deptId,
    method: 'get'
  })
}
// 查询商品分类详细
export function getCategory(categoryId) {
  return request({
    url: '/goods/category/' + categoryId,
    method: 'get'
  })
}
// 查询分类下拉树结构
export function treeselect() {
  return request({
    url: '/goods/category/treeselect',
    method: 'get'
  })
}

// 新增商品分类
export function addCategory(data) {
  return request({
    url: '/goods/category',
    method: 'post',
    data: data
  })
}

// 修改商品分类
export function updateCategory(data) {
  return request({
    url: '/goods/category',
    method: 'put',
    data: data
  })
}

// 删除商品分类
export function delCategory(categoryId) {
  return request({
    url: '/goods/category/' + categoryId,
    method: 'delete'
  })
}
