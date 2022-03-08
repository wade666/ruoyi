import request from '@/utils/request'

// 查询仓库所属公司列表
export function listCompany(query) {
  return request({
    url: '/goods/company/list',
    method: 'get',
    params: query
  })
}

// 查询仓库所属公司详细
export function getCompany(companyId) {
  return request({
    url: '/goods/company/' + companyId,
    method: 'get'
  })
}

// 新增仓库所属公司
export function addCompany(data) {
  return request({
    url: '/goods/company',
    method: 'post',
    data: data
  })
}

// 修改仓库所属公司
export function updateCompany(data) {
  return request({
    url: '/goods/company',
    method: 'put',
    data: data
  })
}

// 删除仓库所属公司
export function delCompany(companyId) {
  return request({
    url: '/goods/company/' + companyId,
    method: 'delete'
  })
}
