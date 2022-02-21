import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";
// 查询商品列表
export function listProduct(query) {
  return request({
    url: '/goods/product/list',
    method: 'get',
    params: query
  })
}

// 查询商品详细
export function getProduct(id) {
  return request({
    url: '/goods/product/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增商品
export function addProduct(data) {
  return request({
    url: '/goods/product',
    method: 'post',
    data: data
  })
}

// 修改商品
export function updateProduct(data) {
  return request({
    url: '/goods/product',
    method: 'put',
    data: data
  })
}

// 删除商品
export function delProduct(id) {
  return request({
    url: '/goods/product/' + id,
    method: 'delete'
  })
}
// 上下架修改
export function changeProductStatus(id, isMarketable) {
  const data = {
    id,
    isMarketable
  }
  return request({
    url: '/goods/product/changeProductStatus',
    method: 'put',
    data: data
  })
}
