import request from '@/utils/request'

// 查询物流拒收配置列表
export function listConfig(query) {
  return request({
    url: '/goods/config/list',
    method: 'get',
    params: query
  })
}

// 查询物流拒收配置详细
export function getConfig(reverseId) {
  return request({
    url: '/goods/config/' + reverseId,
    method: 'get'
  })
}

// 新增物流拒收配置
export function addConfig(data) {
  return request({
    url: '/goods/config',
    method: 'post',
    data: data
  })
}

// 修改物流拒收配置
export function updateConfig(data) {
  return request({
    url: '/goods/config',
    method: 'put',
    data: data
  })
}

// 删除物流拒收配置
export function delConfig(reverseId) {
  return request({
    url: '/goods/config/' + reverseId,
    method: 'delete'
  })
}
