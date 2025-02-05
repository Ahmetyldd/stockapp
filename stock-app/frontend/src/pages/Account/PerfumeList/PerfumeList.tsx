import React, { FC, ReactElement, useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { UnorderedListOutlined } from "@ant-design/icons";
import { Col, notification, Pagination, Row } from "antd";

import { selectIsProductDeleted } from "../../../redux-toolkit/admin/admin-selector";
import { selectIsProductsLoading, selectProducts } from "../../../redux-toolkit/perfumes/perfumes-selector";
import { fetchProducts, fetchProductsByInputText } from "../../../redux-toolkit/perfumes/perfumes-thunks";
import { resetProductsState } from "../../../redux-toolkit/perfumes/perfumes-slice";
import { resetAdminState } from "../../../redux-toolkit/admin/admin-slice";
import ContentTitle from "../../../components/ContentTitle/ContentTitle";
import SelectSearchData from "../../../components/SelectSearchData/SelectSearchData";
import InputSearch from "../../../components/InputSearch/InputSearch";
import ProductCard from "../../../components/ProductCard/ProductCard";
import { deleteProduct } from "../../../redux-toolkit/admin/admin-thunks";
import { LoadingStatus, ProductResponse } from "../../../types/types";
import DeleteModal from "./DeleteModal/DeleteModal";
import Spinner from "../../../components/Spinner/Spinner";
import { MAX_PAGE_VALUE, usePagination } from "../../../hooks/usePagination";
import { useSearch } from "../../../hooks/useSearch";
import "./ProductList.css";

const ProductList: FC = (): ReactElement => {
    const dispatch = useDispatch();
    const perfumes = useSelector(selectProducts);
    const isProductsLoading = useSelector(selectIsProductsLoading);
    const isProductDeleted = useSelector(selectIsProductDeleted);
    const [perfumeInfo, setProductInfo] = useState<ProductResponse>();
    const [isModalVisible, setIsModalVisible] = useState<boolean>(false);
    const { currentPage, totalElements, handleChangePagination } = usePagination();
    const { searchValue, searchTypeValue, onSearch, handleChangeSelect } = useSearch();

    useEffect(() => {
        dispatch(fetchProducts(0));

        return () => {
            dispatch(resetProductsState());
            dispatch(resetAdminState(LoadingStatus.LOADING));
        };
    }, []);

    useEffect(() => {
        if (isProductDeleted) {
            window.scrollTo(0, 0);
            notification.success({
                message: "Product deleted",
                description: "Product successfully deleted!"
            });
        }
    }, [isProductDeleted]);

    const changePagination = (page: number, pageSize: number): void => {
        if (searchValue) {
            dispatch(
                fetchProductsByInputText({ searchType: searchTypeValue, text: searchValue, currentPage: page - 1 })
            );
        } else {
            dispatch(fetchProducts(page - 1));
        }
        handleChangePagination(page, pageSize);
    };

    const showDeleteModalWindow = (perfume: ProductResponse): void => {
        setIsModalVisible(true);
        setProductInfo(perfume);
    };

    const deleteProductHandler = (): void => {
        dispatch(deleteProduct(perfumeInfo?.id!));
    };

    const handleCancel = (): void => {
        setIsModalVisible(false);
    };

    return (
        <div>
            <ContentTitle title={"List of perfumes"} titleLevel={4} icon={<UnorderedListOutlined />} />
            <Row>
                <Col span={24}>
                    <Row>
                        <Col span={9}>
                            <SelectSearchData handleChangeSelect={handleChangeSelect} />
                        </Col>
                        <Col span={10}>
                            <InputSearch onSearch={onSearch} />
                        </Col>
                    </Row>
                    {isProductsLoading ? (
                        <Spinner />
                    ) : (
                        <>
                            <Row style={{ marginTop: 16, marginBottom: 16 }}>
                                <Col span={16}>
                                    <Pagination
                                        current={currentPage}
                                        pageSize={MAX_PAGE_VALUE}
                                        total={totalElements}
                                        showSizeChanger={false}
                                        onChange={changePagination}
                                    />
                                </Col>
                            </Row>
                            <Row gutter={[32, 32]}>
                                {perfumes.map((perfume) => (
                                    <ProductCard
                                        key={perfume.id}
                                        perfume={perfume}
                                        colSpan={8}
                                        onOpenDelete={showDeleteModalWindow}
                                        edit
                                    />
                                ))}
                            </Row>
                            <Row style={{ marginTop: 16, marginBottom: 16 }}>
                                <Pagination
                                    current={currentPage}
                                    pageSize={MAX_PAGE_VALUE}
                                    total={totalElements}
                                    showSizeChanger={false}
                                    onChange={changePagination}
                                />
                            </Row>
                        </>
                    )}
                </Col>
            </Row>
            <DeleteModal
                visible={isModalVisible}
                deleteProductHandler={deleteProductHandler}
                handleCancel={handleCancel}
                perfumeInfo={perfumeInfo}
            />
        </div>
    );
};

export default ProductList;
